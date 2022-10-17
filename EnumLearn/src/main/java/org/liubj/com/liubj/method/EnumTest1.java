package org.liubj.com.liubj.method;

public class EnumTest1 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING.getName1() + "\t" + Season.SPRING.getDec1());
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
        String name = Season.SPRING.name();
        System.out.println(name);

        System.out.println("*******************************************************");
        Season[] values = Season.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("*******************************************************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        System.out.println("*******************************************************");
        Season spring1 = Season.getSeason("Spring");
        System.out.println(spring1);
    }

    interface Info{
        void show();
    }
    enum Season implements Info{
        SPRING("Spring","春意盎然"){
            @Override
            public void show() {
                System.out.println("春天在哪里");
            }
        },

        SUMMERY("Summery","夏日炎炎"){
            @Override
            public void show() {
                System.out.println("宁夏");
            }
        };

        String name1;
        String dec1;

        Season(String name1, String dec1) {
            this.name1 = name1;
            this.dec1 = dec1;
        }

        public String getName1() {
            return name1;
        }

        public String getDec1() {
            return dec1;
        }

        public static Season getSeason(String str){

            for (Season season : values()){
                if (season.name1.equals(str)){
                    return season;
                }
            }
            return null;
        }
    }
}
