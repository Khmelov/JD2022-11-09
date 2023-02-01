package by.it._examples_.jd02_08.samples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonToFlatMap {
    final static String rawData = """
                {
                  "_index": "logs",
                  "_type": "doc",
                  "_id": "5ayvInYBSGzODwRDvwOP",
                  "_version": 1,
                  "_score": null,
                  "_source": {
                    "@version": "1",
                    "time_lag": 0,
                    "ls_hostname_umsc": "tkle-um0067.vm.ru",
                    "thread": "HikariPool-2 connection adder",
                    "level": "ERROR",
                    "@timestamp": "2020-12-02T09:01:51.835Z",
                    "threadId": 1671,
                    "endOfBatch": true,
                    "application_host": "10.00.000.70",
                    "threadPriority": 5,
                    "environment": "dev",
                    "loggerFqcn": "org.apache.logging.slf4j.Log4jLogger",
                    "cluster_name": "info",
                    "ls_processed_timestamp": "2020-12-02T09:01:51.885Z",
                    "req_headers": {
                      "request_path": "/",
                      "content_type": "application/json; charset=UTF-8",
                      "connection": "keep-alive",
                      "http_user_agent": "Java/1.8.0_262",
                      "content_length": "394",
                      "http_host": "tkle-um0067.ru:44441",
                      "http_accept": "text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2",
                      "http_version": "HTTP/1.1",
                      "request_method": "POST"
                    },
                    "transport": "beat",
                    "loggerName": "org.apache.hive.jdbc.Utils",
                    "app_id": "spm-app-4c09-8966",
                    "tags": [
                      "app",
                      "dev",
                      "info",
                      "calculated_diff",
                      "host_unknown"
                    ],
                    "instant": {
                      "epochSecond": 1606899711,
                      "nanoOfSecond": 823000000
                    },
                    "ls_processed_idxstamp": "2020.12.02.12",
                    "appname": "datatube",
                    "message": "Unable to read HiveServer2 configs from ZooKeeper"
                  },
                  "fields": {
                    "ls_processed_timestamp": [
                      "2020-12-02T09:01:51.885Z"
                    ],
                    "@timestamp": [
                      "2020-12-02T09:01:51.835Z"
                    ]
                  },
                  "sort": [
                    1606899711835,
                    123456
                  ]
                }
            """.trim();

    public static void main(String[] args) throws JsonProcessingException {
        LinkedHashMap<?, ?> map = new ObjectMapper().readValue(rawData, LinkedHashMap.class);
        LinkedHashMap<String, Object> all = new LinkedHashMap<>();

        System.out.println("all as flat map");
        fill(all, null, map);
        all.forEach((key, value) -> System.out.println(key + "=" + value));

        //find node
        System.out.println("\n_source");
        Map<String, Object> flatMap = fill("_source", map);
        flatMap.forEach((key, value) -> System.out.println(key + "=" + value));

        //find next node
        System.out.println("\nfields");
        fill("fields", map).forEach((key, value) -> System.out.println(key + "=" + value));

        //next value
        System.out.println("\nsort");
        fill("sort", map).forEach((key, value) -> System.out.println(key + "=" + value));
    }

    private static Map<String, Object> fill(Object key, Map<?, ?> map) {
        return fill(new LinkedHashMap<>(), key, map);
    }

    private static Map<String, Object> fill(Map<String, Object> flatMap, Object key, Map<?, ?> map) {
        Object value = map.get(key);
        if (value instanceof LinkedHashMap || key == null) {
            Map<?, ?> node = key == null ? map : (Map<?, ?>) value;
            for (Map.Entry<?, ?> entry : node.entrySet()) {
                fill(flatMap, entry.getKey(), node);
            }
        } else {
            flatMap.put(key.toString(), value);
        }
        //if do not process arrays - it be as Object for key
        return flatMap;
    }

    static Object get(String key, Map<?, ?> map) {
        String[] parts = key.split("/", 2);
        Object value = map.get(parts[0]);
        return parts.length < 2
                ? value
                : get(parts[1], (Map<?, ?>) value);
    }


}