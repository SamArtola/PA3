package util;

import java.io.PrintWriter;

public class Teacher implements CSVPrintable {
    protected String name, job, Tid, Sid;
    protected int phone;

    public Teacher(String job, String name, String Sid, String Tid, int phone) {
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
        return Integer.parseInt(Tid);
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + phone);
        out.flush();
    }
}
