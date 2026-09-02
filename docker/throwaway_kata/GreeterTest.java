// The test half of the workload the AOT caches are recorded from. It sets an
// expectation on a mocked collaborator, which is what pulls jMock's imposteriser
// and its JUnit 4 integration into the cache alongside JUnit's own runner.
//
// It passes, because a JVM writes a cache when it exits of its own accord and a
// green run is the simplest way to be sure of that.
import org.junit.Rule;
import org.junit.Test;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;

public class GreeterTest {

    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

    Listener listener = context.mock(Listener.class);

    @Test
    public void tells_its_listener_what_it_said() {
        context.checking(new Expectations() {{
            oneOf(listener).heard("hello");
        }});
        new Greeter(listener).greet();
    }
}
