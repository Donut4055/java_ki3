package bt7;

public class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setResearchTopic(String researchTopic) {
        if (researchTopic == null) {
            System.out.println("Đề tài không hợp lệ.");
            return;
        }
        this.researchTopic = researchTopic;
    }

    public void setSupervisorName(String supervisorName) {
        if (supervisorName == null) {
            System.out.println("Tên GVHD không hợp lệ.");
            return;
        }
        this.supervisorName = supervisorName;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Đề tài: " + researchTopic + ", GVHD: " + supervisorName;
    }
}
