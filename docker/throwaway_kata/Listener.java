// The collaborator the throwaway kata mocks. jMock's value is in standing in
// for a collaborator, so the recorded workload needs one; without an interface
// to imposterise, the classes that make jMock worth caching never load.
public interface Listener {

    void heard(String greeting);
}
