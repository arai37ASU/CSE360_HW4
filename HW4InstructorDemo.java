import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a request submitted by a student to become a reviewer.
 */
class ReviewerRequest {
    private String studentName;
    private String studentId;
    private String status; // "pending", "approved", "denied"
    private String instructorNote;

    public ReviewerRequest(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.status = "pending";
        this.instructorNote = "";
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStatus() {
        return status;
    }

    public String getInstructorNote() {
        return instructorNote;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInstructorNote(String instructorNote) {
        this.instructorNote = instructorNote;
    }

    @Override
    public String toString() {
        return studentName + " (" + studentId + ") - " + status;
    }
}

/**
 * A GUI page that allows instructors to manage reviewer requests.
 */
class InstructorHomePage extends JFrame {
    public InstructorHomePage(ArrayList<ReviewerRequest> requests) {
        setTitle("Instructor - Manage Reviewer Requests");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        for (ReviewerRequest req : requests) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(req.toString());
            JTextField noteField = new JTextField(15);
            JButton approveBtn = new JButton("Approve");
            JButton denyBtn = new JButton("Deny");

            approveBtn.addActionListener(e -> {
                req.setStatus("approved");
                req.setInstructorNote(noteField.getText());
                label.setText(req.toString());
            });

            denyBtn.addActionListener(e -> {
                req.setStatus("denied");
                req.setInstructorNote(noteField.getText());
                label.setText(req.toString());
            });

            panel.add(label);
            panel.add(noteField);
            panel.add(approveBtn);
            panel.add(denyBtn);
            container.add(panel);
        }

        JScrollPane scrollPane = new JScrollPane(container);
        add(scrollPane);
    }
}

/**
 * Entry point to launch the Instructor review request demo.
 */
public class HW4InstructorDemo {
    public static void main(String[] args) {
        ArrayList<ReviewerRequest> mockRequests = new ArrayList<>();
        mockRequests.add(new ReviewerRequest("Alice Johnson", "S101"));
        mockRequests.add(new ReviewerRequest("Bob Smith", "S102"));
        mockRequests.add(new ReviewerRequest("Charlie Lee", "S103"));

        InstructorHomePage homePage = new InstructorHomePage(mockRequests);
        homePage.setVisible(true);
    }
}