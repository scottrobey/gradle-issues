package org.example.gradle6;

import java.util.Arrays;
import java.util.Collection;

import com.google.common.collect.ImmutableList;

public class Production {

    public Collection<String> doSomething() {
        String[] array = { "if", "the", "rule", "you", "followed", "brought", "you", "to", "this,", "of", "what", "use", "was", "the", "rule" };
        // we know this ImmutableList method doesn't exist in the Android version of Guava so use it here
        Collection<String> immutable = Arrays.asList(array).stream().collect(ImmutableList.toImmutableList());

        System.out.println("Immutable List: " + immutable);
        return immutable;
    }

    public static void main(String args[]) {
        new Production().doSomething();
    }
}
