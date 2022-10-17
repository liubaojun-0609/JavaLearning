package org.liubj.com.liubj.method;

/**
 * 自定义注解
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(SeasonEnum.SPRING.toString());
        System.out.println(SeasonEnum.SUMMERY.getName() + "\t" + SeasonEnum.SUMMERY.getDec());
    }
}

class SeasonEnum{
    private final String name;
    private final String dec;

    //自定义枚举 不可更改
    private SeasonEnum(String name, String dec) {
        this.name = name;
        this.dec = dec;
    }

    public static final SeasonEnum SPRING= new SeasonEnum("Spring","春意盎然");
    public static final SeasonEnum SUMMERY = new SeasonEnum("Summery","夏日炎炎");

    public String getName() {
        return name;
    }

    public String getDec() {
        return dec;
    }


    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", dec='" + dec + '\'' +
                '}';
    }
}
