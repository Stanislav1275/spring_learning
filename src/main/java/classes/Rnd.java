package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class Rnd {
    final private Set<Integer> rnds = new HashSet<>();
    int max;
    int min;

    @Autowired
    public void setMax(int max) {
        this.max = max;
    }

    @Autowired
    public void setMin(int min) {
        this.min = min;
    }

    public int rnd() {
        Random random = new Random();
        int range = max - min + 1;
        if (rnds.size() == range) {
            System.out.println("clear");
            rnds.clear();
        }
        int number;
        do {
            number = random.nextInt(range) + min;
        } while (rnds.contains(number));
        rnds.add(number);
        return number;
    }
}
