package eu.csaware.stix2.test.reference;

import eu.csaware.stix2.common.TypedStixObject;
import eu.csaware.stix2.common.Stix2Type;
import eu.csaware.stix2.sdos.CourseOfAction;
import eu.csaware.stix2.test.util.TestConstants;
import eu.csaware.stix2.test.util.TestUtil;
import eu.csaware.stix2.util.Stix2Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 *
 */
class CourseOfActionTest {

    private static final String PATH = "reference/course_of_action.json";
    private static CourseOfAction courseOfAction;

    @BeforeAll
    static void setUp() throws Exception {
        String jsonString = TestUtil.readResourceFile(PATH);
        courseOfAction = Stix2Gson.DEBUG.fromJson(jsonString, CourseOfAction.class);
    }

    @AfterAll
    static void tearDown() throws Exception {
    }

    @Test
    void testType() {
        Assertions.assertEquals(Stix2Type.COURSE_OF_ACTION, courseOfAction.getType());
    }

    @Test
    void testId() {
        Assertions.assertEquals(TestConstants.COURSE_OF_ACTION_ID, courseOfAction.getId());
    }

    @Test
    void testName() {
        Assertions.assertEquals("Add TCP port 80 Filter Rule to the existing Block UDP 1434 Filter", courseOfAction.getName());
    }

    @Test
    void testDescription() {
        Assertions.assertEquals("This is how to add a filter rule to block inbound access to TCP port 80 to the existing UDP 1434 filter ...", courseOfAction.getDescription());
    }

    @Test
    void testCreated() {
        Assertions.assertEquals(TestConstants.DATE_TIME_CREATED, courseOfAction.getCreated());
    }

    @Test
    void testModified() {
        Assertions.assertEquals(TestConstants.DATE_TIME_MODIFIED, courseOfAction.getModified());
    }

    @Test
    void testCreatedByRef() {
        Assertions.assertEquals(TestConstants.IDENTITY_ID, courseOfAction.getCreatedByRef());
    }

    @Test
    void testRevoked() {
        Assertions.assertNull(courseOfAction.getRevoked());
    }

    @Test
    void testGranularMarkings() {
        Assertions.assertNotNull(courseOfAction.getGranularMarkings());
        Assertions.assertEquals(0, courseOfAction.getGranularMarkings().size());
    }

    @Test
    void testObjectMarkingRefs() {
        Assertions.assertNotNull(courseOfAction.getObjectMarkingRefs());
        Assertions.assertEquals(0, courseOfAction.getObjectMarkingRefs().size());
    }

    @Test
    void testLabels() {
        Assertions.assertNotNull(courseOfAction.getLabels());
        Assertions.assertEquals(0, courseOfAction.getLabels().size());
    }

    @Test
    void testNullSafety() {
        CourseOfAction courseOfAction = new CourseOfAction();
        Assertions.assertNotNull(courseOfAction.getGranularMarkings());
        Assertions.assertNotNull(courseOfAction.getObjectMarkingRefs());
        Assertions.assertNotNull(courseOfAction.getLabels());
    }

    @Test
    void testCreation() throws IOException {
        CourseOfAction courseOfAction = new CourseOfAction(
            TestConstants.COURSE_OF_ACTION_UUID,
            "Add TCP port 80 Filter Rule to the existing Block UDP 1434 Filter",
            "This is how to add a filter rule to block inbound access to TCP port 80 to the existing UDP 1434 filter ...",
            TestConstants.IDENTITY_ID,
            TestConstants.DATE_TIME_CREATED,
            TestConstants.DATE_TIME_MODIFIED
        );
        Assertions.assertNotNull(courseOfAction);
        String created = Stix2Gson.DEBUG.toJson(courseOfAction);
        String jsonString = TestUtil.readResourceFile(PATH);
        Assertions.assertEquals(TestUtil.sanitizeJson(jsonString), TestUtil.sanitizeJson(created));
        TestUtil.writeSerializedOutputFile(PATH, created);
    }

    @Test
    void testAutoType() throws IOException {
        String jsonString = TestUtil.readResourceFile(PATH);
        TypedStixObject core = Stix2Gson.DEBUG.fromJson(jsonString, TypedStixObject.class);
        Assertions.assertTrue(core instanceof CourseOfAction);
    }
}
