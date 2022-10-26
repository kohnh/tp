package seedu.duke.utils;

import org.junit.jupiter.api.Test;
import seedu.duke.model.LessonType;
import seedu.duke.model.Module;
import seedu.duke.model.SelectedModule;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {
    @Test
    public void openPreviousState_file_state() {
        Ui ui = new Ui();
        Storage storage = new Storage();
        State actualState = new State();
        storage.openPreviousState(actualState, ui);
        assertEquals(1, actualState.getSemester());
        List<SelectedModule> selectedModules = actualState.getSelectedModulesList();
        SelectedModule selectedModule1 = selectedModules.get(0);
        Module module1 = selectedModule1.getModule();
        assertEquals("CS1010", module1.moduleCode);
        Map<LessonType, String> selectedSlots1 = selectedModule1.getSelectedSlots();
        assertEquals("01", selectedSlots1.get(LessonType.TUTORIAL));
        assertEquals("1", selectedSlots1.get(LessonType.SECTIONAL_TEACHING));

        SelectedModule selectedModule2 = selectedModules.get(1);
        Module module2 = selectedModule2.getModule();
        assertEquals("CS2113", module2.moduleCode);
        Map<LessonType, String> selectedSlots2 = selectedModule2.getSelectedSlots();
        assertEquals("4", selectedSlots2.get(LessonType.TUTORIAL));
        assertEquals("1", selectedSlots2.get(LessonType.LECTURE));
    }
}
