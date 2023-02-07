public class WordSorting extends SortingProgram {
    @Override
    String getSortedObjectType() {
        return "words";
    }

    @Override
    Object takeObject() {
        return scanner.next();
    }
}
