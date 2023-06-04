package pro.sky24;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    public class StringListImplTest {
        private final StringList stringList = new StringListImpl();

        @AfterEach
        public void afterEach() {
            stringList.clear();
        }

        @Test
        void addTest() {
            String[] elements = {"test1", "test2", "test3", "test4", "test5"};
//        add(elements);

            for (int i = 0; i < elements.length; i++) {
                assertThat(stringList.get(i)).isEqualTo(elements[i]);
                assertThat(stringList.contains(elements[i])).isTrue();
                assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
                assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
            }
            assertThat(stringList.toArray()).hasSize(elements.length);
            assertThat(stringList.toArray()).containsExactly(elements);
        }

        @Test
        void addByIndexTest(){
            String [] elements = {"test1", "test2", "test3", "test4", "test5"};
            stringList.add(0,"test");
            assertThat(stringList.size()).isEqualTo(elements.length +1);
            assertThat(stringList.get(0)).isEqualTo("test");

            stringList.add(3,"test");
            assertThat(stringList.size()).isEqualTo(elements.length +2);
            assertThat(stringList.get(3)).isEqualTo("test");
            assertThat(stringList.lastIndexOf("test")).isEqualTo(3);
            assertThat(stringList.indexOf("test")).isEqualTo(0);

            stringList.add(7,"test");
            assertThat(stringList.size()).isEqualTo(elements.length +3);
            assertThat(stringList.get(7)).isEqualTo("test");
            assertThat(stringList.lastIndexOf("test")).isEqualTo(7);
            assertThat(stringList.indexOf("test")).isEqualTo(0);
        }
    }

}
