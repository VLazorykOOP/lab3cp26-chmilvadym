public class ExpelledState implements StudentState {
    @Override
    public void performAction() {
        System.out.println("Студент відрахований і більше не навчається.");
    }
}
