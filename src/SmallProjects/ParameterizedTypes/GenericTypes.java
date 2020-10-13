package SmallProjects.ParameterizedTypes;

public class GenericTypes {

    public static void main(String[] args) {

        OrderedPair<String, Integer> firstVariable = new OrderedPair<String, Integer>("Jeden", 1);
        OrderedPair<String, String> secondVariable = new OrderedPair<>("Dwa", "2");

        System.out.println(firstVariable.getKey() + " " + firstVariable.getValue());
        System.out.println(secondVariable.getKey() + " " + secondVariable.getValue());
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}

interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
