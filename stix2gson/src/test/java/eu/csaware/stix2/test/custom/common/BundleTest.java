package eu.csaware.stix2.test.custom.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.csaware.stix2.common.Bundle;
import eu.csaware.stix2.common.Types;
import eu.csaware.stix2.test.util.TestUtil;
import eu.csaware.stix2.util.GsonSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BundleTest {

    public static final String PATH = "custom/common/bundle_test.json";
    private static Bundle testBundle;

    @BeforeAll
    static void setUp() throws Exception {
        String jsonString = TestUtil.readResourceFile(PATH);
        testBundle = Bundle.buildFromString(jsonString);
    }

    @AfterAll
    static void tearDown() throws Exception {
    }

    @Test
    void writeToFile() throws Exception {
        String content = GsonSingleton.DEBUG.toJson(testBundle);
        TestUtil.writeSerializedOutputFile(PATH, content);
        System.out.println("bundle: " + content);
    }

    @Test
    void getType() {
        Assertions.assertEquals(Types.BUNDLE_TYPE, testBundle.getType());
    }
//
//	@Test
//	public void setType() {
//	}
//
//	@Test
//	public void getId() {
//	}
//
//	@Test
//	public void setId() {
//	}
//
//	@Test
//	public void getSpecVersion() {
//	}
//
//	@Test
//	public void setSpecVersion() {
//	}
//
//	@Test
//	public void getObjects() {
//	}
//
//	@Test
//	public void setObjects() {
//	}
//
//	@Test
//	public void toStringTest() {
//		System.out.println(testBundle.toString());
//	}
}