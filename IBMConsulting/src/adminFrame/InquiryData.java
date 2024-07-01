package adminFrame;

class InquiryData {
    private String problem;
    private String fullName;
    private String date;

    public InquiryData(String problem, String fullName, String date) {
        this.problem = problem;
        this.fullName = fullName;
        this.date = date;
    }

    public String getProblem() {
        return problem;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDate() {
        return date;
    }
}