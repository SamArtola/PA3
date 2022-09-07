package util;



public class TA extends Student {
    public TA(String job, String name, String Tid, String Sid, long phone) {
        super(job, name, Tid, Sid, phone);
    }

    @Override
    public int getID() {
        int student = Integer.parseInt(Sid);
        int teach = Integer.parseInt(Tid);
        if (student < teach)
            return teach;
        else
            return student;
    }

}
