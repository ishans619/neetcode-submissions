class Pair{
    String value;
    int timestamp;

    public Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);

        String ans = "";

        for(Pair p : list){
            if(p.timestamp <= timestamp){
                ans = p.value;
            }
            else{
                break;
            }
        }
        return ans;
    }
}
