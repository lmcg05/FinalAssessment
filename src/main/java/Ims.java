



import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemsController;

import com.qa.persistence.Domain;
import com.qa.persistence.MYsqlCustomerDao;
import com.qa.persistence.MYsqlItemsDao;

import com.qa.services.CustomerService;
import com.qa.services.ItemsService;



import Utils.Utils;

public class Ims {
	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = Utils.getInput();
		LOGGER.info("What is your password");
		String password = Utils.getInput();

		boolean looper = true;
		while (looper) {

			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			Domain domain = Domain.getDomain();
			Action action = null;

			if (domain != Domain.STOP) {
				LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");
				Action.printActions();
				action = Action.getAction();
			}

			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(
						new CustomerService(new MYsqlCustomerDao(username, password)));
				doAction(customerController, action);
				break;
			case ITEM:
				ItemsController itemsController = new ItemsController(
						new ItemsService(new MYsqlItemsDao(username, password)));
				doAction(itemsController, action);
				break;
			case ORDER:
				break;
			case STOP:
				looper = false;
				break;
			default:
				break;
			}
		}
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}
