package application;

/**
 * Represents a request submitted by a student to become a reviewer.
 * <p>
 * Contains information about the student, their qualifications, the submission date,
 * and the current status of the request (e.g., "Pending", "Approved", "Denied").
 * </p>
 */
public class ReviewerRequest {

    private String id;
    private String studentName;
    private String qualifications;
    private String dateSubmitted;
    private String status; // "Pending", "Approved", "Denied"

    /**
     * Constructs a new ReviewerRequest with the specified details.
     *
     * @param id             the unique identifier of the request
     * @param studentName    the name of the student submitting the request
     * @param qualifications a description of the student's qualifications
     * @param dateSubmitted  the date the request was submitted
     * @param status         the status of the request ("Pending", "Approved", or "Denied")
     */
    public ReviewerRequest(String id, String studentName, String qualifications,
                           String dateSubmitted, String status) {
        this.id = id;
        this.studentName = studentName;
        this.qualifications = qualifications;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
    }

    /**
     * Returns the unique ID of this request.
     *
     * @return the request ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the student who submitted the request.
     *
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Returns the qualifications provided by the student.
     *
     * @return the qualifications text
     */
    public String getQualifications() {
        return qualifications;
    }

    /**
     * Returns the submission date of the request.
     *
     * @return the submission date
     */
    public String getDateSubmitted() {
        return dateSubmitted;
    }

    /**
     * Returns the current status of the request.
     *
     * @return the request status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the request.
     *
     * @param status the new status to assign ("Pending", "Approved", or "Denied")
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
