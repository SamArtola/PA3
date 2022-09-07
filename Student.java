package util;

import java.io.PrintWriter;

public class Student implements CSVPrintable {
    protected String name;
    protected String job;
    protected String Tid,Sid;
    protected long phone;

    public Student(String job, String name, String Sid, String Tid, long phone) {
        this.job = job;
        this.name = name;
        this.Tid = Tid;
        this.Sid = Sid;
        this.phone = phone;
    }

    @Override
    public String getName() {
        name=name.replace(","," ");
        return name;
    }

    @Override
    public int getID() {
        return Integer.parseInt(Sid);
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + phone);
        out.flush();
    }
}
