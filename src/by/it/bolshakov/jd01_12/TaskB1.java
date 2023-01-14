package by.it.bolshakov.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    static final String text =
            "\n" +
                    "Nadine Gordimer \n" +
                    "\n" +
                    "\n" +
                    "Nadine Gordimer \n" +
                    "\n" +
                    "Once upon a Time \n" +
                    "\n" +
                    "Someone has written to ask me to contribute to an anthology of stories for children. I \n" +
                    "reply that I don't write children's stories; and he writes back that at a recent congress/book \n" +
                    "fair/seminar a certain novelist said every writer ought to write at least one story for \n" +
                    "children. I think of sending a postcard saying I don't accept that I \"ought\" to write anything. \n" +
                    "\n" +
                    "And then last night I woke up — or rather was awakened without knowing what had \n" +
                    "roused me. \n" +
                    "\n" +
                    "A voice in the echo-chamber of the subconscious? \n" +
                    "\n" +
                    "A sound. \n" +
                    "\n" +
                    "A creaking of the kind made by the weight carried by one foot after another along a \n" +
                    "wooden floor. I listened. I felt the apertures of my ears distend with concentration. Again: \n" +
                    "the creaking. I was waiting for it; waiting to hear if it indicated that feet were moving from \n" +
                    "room to room, coming up the passage — to my door. I have no burglar bars, no gun under the \n" +
                    "pillow, but I have the same fears as people who do take thse precautions, and my \n" +
                    "windowpanes are thin as rime, could shatter like a wineglass. A woman was murdered (how \n" +
                    "do they put it) in broad daylight in a house two blocks away, last year, and the fierce dogs \n" +
                    "who guarded an old widower and his collection of antique clocks were strangled before he \n" +
                    "was knifed by a casual laborer he had dismissed without pay. \n" +
                    "\n" +
                    "I was staring at the door, making it out in my mind rather than seeing it, in the dark. I lay quite \n" +
                    "still — a victim already — the arrhythmia of my heart was fleeing, knocking this way and that \n" +
                    "against its body-cage. How finely tuned the senses are, just out of rest, sleep! I could never listen \n" +
                    "intently as that in the distractions of the day, I was reading every faintest sound, identifying and \n" +
                    "classifying its possible threat. \n" +
                    "\n" +
                    "But I learned that I was to be neither threatened nor spared. There was no human weight \n" +
                    "pressing on the boards, the creaking was a buckling, an epicenter of stress. I was in it. The house \n" +
                    "that surrounds me while I sleep is built on undermined ground; far beneath my bed, the floor, the \n" +
                    "house's foundations, the stopes and passages of gold mines have hollowed the rock, and when some \n" +
                    "face trembles, detaches and falls, three thousand feet below, the whole house shifts slightly, \n" +
                    "bringing uneasy strain to the balance and counterbalance of brick, cement, wood and glass that hold it \n" +
                    "as a structure around me. The misbeats of my heart tailed off like the last muffled flourishes on one \n" +
                    "of the wooden xylophones made by the Chopi and T songa 1 migrant miners who might have been \n" +
                    "down there, under me in the earth at that moment. The stope where the fall was could have been \n" +
                    "disused, dripping water from its ruptured veins; or men might now be interred there in the most \n" +
                    "profound of tombs. \n" +
                    "\n" +
                    "I couldn't find a position in which my mind would let go of my body — release me to sleep \n" +
                    "again. So I began to tell myself a story, a bedtime story. \n" +
                    "\n" +
                    "In a house, in a suburb, in a city, there were a man and his wife who loved each other very much \n" +
                    "and were living happily ever after. They had a little boy, and they loved him very much. They had \n" +
                    "a cat and a dog that the little boy loved very much. They had a car and a caravan trailer for \n" +
                    "holidays, and a swimming-pool which was fenced so that the little boy and his playmates would \n" +
                    "not fall in and drown. They had a housemaid who was absolutely trustworthy and an itinerant \n" +
                    "gardener who was highly recommended by the neighbors. For when they began to live happily ever \n" +
                    "after they were warned, by that wise old witch, the husband's mother, not to take on anyone off the \n" +
                    "street. They were inscribed in a medical benefit society, their pet dog was licensed, they were \n" +
                    "insured against fire, flood damage and theft, and subscribed to the local Neighborhood Watch, \n" +
                    "which supplied them with a plaque for their gates lettered Y OU HAVE BEEN WARNED \n" +
                    "over the silhouette of a would-be intruder. He was masked; it could not be said if he was \n" +
                    "black or white, and therefore proved the property owner was no racist. \n" +
                    "\n" +
                    "It was not possible to insure the house, the swimming pool or the car against riot \n" +
                    "damage. There were riots, but these were outside the city, where people of another color \n" +
                    "were quartered. These people were not allowed into the suburb except as reliable\n" +
                    "end\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(text);
        Map<String, Integer> words = new HashMap<>();
        for (; ; ) {
            String word = scanner.next();
            word = word.replaceAll("[.,-:;\"]", "");
            if (word.equals("end")) {
                break;
            }
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        System.out.println(words);
    }
}
