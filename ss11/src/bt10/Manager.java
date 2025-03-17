package bt10;

public class Manager extends Employee implements IAttendMeeting {
    private int teamSize;

    public Manager(String name, double salary) {
        super(name, salary);
        this.teamSize = 5;
    }

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public String work() {
        return "Quản lý " + getInfo() + " đang giám sát dự án";
    }

    @Override
    public String takeVacation() {
        return "Quản lý " + getInfo() + " đang đi nghỉ phép tại Pháp.";
    }

    @Override
    public String attendMeeting() {
        return "Quản lý " + getInfo() + " đang tham gia cuộc họp";
    }
}