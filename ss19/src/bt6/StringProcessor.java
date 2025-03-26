package bt6;

import java.util.List;

interface StringProcessor {
    String processString(String input);

    default void printList(List<String> list) {
        System.out.println(list);
    }
}

