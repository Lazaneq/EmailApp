package App;

import App.controller.services.FetchFolderService;
import App.model.EmailAccount;
import App.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

public class EmailManager {

    //Zarzadzanie folderami
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }
    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), treeItem);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
