package studAdmin;

import java.util.InputMismatchException;
import java.util.List;

public class StudIdChecker {

    public Student IdCheck(List<Student> students) {
        if (!students.isEmpty()) {
            try {
                CW.print("Please specify student ID or write Exit to go back: ");
                int oldId = UserInput.intIn.nextInt();
                return checkStudArrListForMatchingIdInAndGoNextMenuIfMatch(students, oldId);
            } catch (InputMismatchException e) {
                CW.newLine();
                CW.print(CW.mismatchExceptionMsg());
                UserInput.intIn.next();
                CW.newLine();
                return null;
            }
        } else {
            CW.print(CW.noStudentsRegisteredMsg());
            CW.newLine();
            return null;
        }
    }

    private Student checkStudArrListForMatchingIdInAndGoNextMenuIfMatch(List<Student> students, int oldId) {
        int i;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == oldId) {
                //System.out.println("id: " + students.get(i).getId() + "name: " + students.get(i).getName());
                return students.get(i);
            } else if (i == students.size() - 1) {
                CW.newLine();
                CW.print(CW.noIntInRegisteredForStudentsMsg(oldId));
                CW.newLine();
            }
        }
        return null;
    }
}

