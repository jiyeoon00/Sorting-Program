public class NumberSorting extends SortingProgram{
    @Override
    String getSortedObjectType() {
        return "numbers";
    }

    @Override
    Object takeObject() {
        return scanner.nextInt();
    }
}
