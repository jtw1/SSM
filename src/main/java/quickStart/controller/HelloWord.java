package quickStart.controller;

/**
 * @Description
 * @date 2020/11/12 0012-22:08
 */
public class HelloWord {
    public String name;

    public HelloWord() {
    }

    public HelloWord(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.print("hello:" + name);
    }
}
