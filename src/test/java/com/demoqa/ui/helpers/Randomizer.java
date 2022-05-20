package com.demoqa.ui.helpers;

import java.util.*;
import java.util.stream.Collectors;

public class Randomizer {

    public String getRandomString(String[] data) {

        return data[new Random().nextInt(data.length)];

    }

    public List<String> getRandomStringList(List<String> data) {

        List<String> res = new ArrayList<>();
        Random rand = new Random();
        int r = rand.nextInt(data.size());

        while (r==0) {
            r = rand.nextInt(data.size());
        }



        for (int i = 0; i < r; i++) {
            int randomIndex = rand.nextInt(data.size());
            res.add(data.get(randomIndex));
         //   data.iterator().remove();
         //   data.removeIf(data.get(randomIndex)::equals);
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public int getRandomNumber(int length) {

        return new Random().nextInt(length);

    }


}
