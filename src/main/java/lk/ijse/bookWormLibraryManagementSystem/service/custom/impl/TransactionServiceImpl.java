package lk.ijse.bookWormLibraryManagementSystem.service.custom.impl;

import lk.ijse.bookWormLibraryManagementSystem.repository.RepositoryFactory;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.TransactionRepository;
import lk.ijse.bookWormLibraryManagementSystem.repository.custom.impl.TransactionRepositoryImpl;
import lk.ijse.bookWormLibraryManagementSystem.service.custom.TransactionService;
import lk.ijse.bookWormLibraryManagementSystem.util.SessionFactoryConfig;
import org.hibernate.Session;

public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository =
            (TransactionRepository) RepositoryFactory.getInstance()
                    .getRepository(RepositoryFactory.RepositoryTypes.TRANSACTION);

    private Session session;

    public void initializeSession() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public int getLastTransactionId() {
        try {
            initializeSession();
            TransactionRepositoryImpl.setSession(session);
            return transactionRepository.getLastId();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

}
