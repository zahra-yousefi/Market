package zaryam.market.repositories.book;

/**
 * Created by 92525252 on 6/7/2016.
 */
public class RepositoryBuilder {

    public static IBookRepository getBookRepository() {
        return new BookStaticListRepository();
        //return new BookDbRepository();
    }
}
