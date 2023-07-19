package com.personetics.test.validator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChainValidator {

    //Here below there are some valid and invalid chains to be tested and the expected result in the console.


//    Valid chain: 36, 6, 24, 4, 47, 7, 2, 3, 27                         - true
//    Valid chain: 10, 1, 0, 5, 15, 1, 5, 30, 3                          - true
//    Valid chain: "p", "aba", "a", "b", "perso", "o", "r", "e", "s"     - true
//    Valid chain: "apple", "a", "p", "le", "e", "l"                     - true

    // Valid chain: 24, 4, 2

//    Not valid chain: "cat", "car" ,"c", "a", "r", "m", "e", "o", "w"   - false
//    Not valid chain: 35, 5, 65, 6, 24, 4                               - false
//    Not valid chain: 25, 2, 5, 10, 2, 0, 4, 8                          - false


    public static void main(String[] args) {
        var nodes = Stream.of(24, 4, 2).map(Node::new).collect(Collectors.toList());

        System.out.println(new ChainValidator().validate(nodes));
    }


    boolean validate(List<Node> nodes) {
        Objects.requireNonNull(nodes, "nodes cannot be null");
        var split = nodes.stream()
                .collect(Collectors.partitioningBy(node -> node.getValue().length() > 1));

        var distinctMultiValues = getDistinctMultiValues(split.get(true));

        var singleValues = getSingleValues(split.get(false));

        return distinctMultiValues
                .stream()
                .allMatch(singleValues::containsAll);
    }

    private List<String> getSingleValues(List<Node> singleValues) {
        return singleValues
                .stream()
                .map(Node::getValue)
                .collect(Collectors.toList());
    }

    private List<List<String>> getDistinctMultiValues(List<Node> multiValues) {
        return multiValues
                .stream()
                .map(Node::getValue)
                .map(value -> Arrays
                        .stream(value.split(""))
                        .distinct()
                        .collect(Collectors.toList()))
                .distinct()
                .collect(Collectors.toList());
    }
}
