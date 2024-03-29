package utility;

import java.sql.*;
import java.util.ArrayList;

import model.WorkflowMaster;

public class WorkflowDBService {

	public static int insertObjectInDB(String workflow_table,
			ArrayList<String> params) {
		int result;
		Connection conn = null;
		PreparedStatement pst = null;
		String insertQuery = "INSERT INTO `" + workflow_table + "`"
				+ " ( `stage_id`,`stage_name`, `stage_description`, `stage_sla`,"
				+ " `stage_seqno`, `w_id`) VALUES (?,?,?,?,?,?)";
		int i = 1;

		try {
			conn = new MySqlConnection().getConnection();
			pst = conn.prepareStatement(insertQuery);

			for (String string : params) {
				//if (i < 3)
					pst.setString(i, string);
				//else
				//	pst.setInt(i, Integer.parseInt(string));
				i++;
			}

			result = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public static int createTables(String workflow_table, String stage_table,
			String item_table, String lead_bucket, String general_bucket) {
		String workflowCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ workflow_table
				+ "` ("
				+ "  `stage_id` int(5) NOT NULL AUTO_INCREMENT,"
				+ "`stage_name` varchar(30) COLLATE utf8_bin NOT NULL,"
				+ "`stage_description` varchar(100) COLLATE utf8_bin NOT NULL,"
				+ "`stage_sla` int(5) NOT NULL COMMENT 'values should be in hours',"
				+ "`stage_seqno` int(5) NOT NULL,"
				+ "`stage_lead_id` int(5) NULL,"
				+ "`w_id` int(5) NOT NULL,"
				+ "PRIMARY KEY (`stage_id`),"
				+ "KEY `stage_lead_id` (`stage_lead_id`),"
				+ " UNIQUE KEY `stage_seqno` (`stage_seqno`),"
				+ "KEY `w_id` (`w_id`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1";

		String workflowConstraintsQuery = "ALTER TABLE `"
				+ workflow_table
				+ "` "

				+ " ADD CONSTRAINT `"
				+ workflow_table
				+ "_ibfk_1` FOREIGN KEY (`stage_lead_id`) REFERENCES "
				+ "`login_credentials` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ " ADD CONSTRAINT `" + workflow_table
				+ "_ibfk_2` FOREIGN KEY (`w_id`) REFERENCES `workflow_master`"
				+ " (`w_id`) ON DELETE CASCADE ON UPDATE CASCADE";

		String stageCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ stage_table + "`(`stage_id` int(5) NOT NULL,"
				+ "`user_id` int(5) NOT NULL,"
				/* + "`status` set('A','I') COLLATE utf8_bin NOT NULL," */
				+ "PRIMARY KEY (`user_id`,`stage_id`),"
				+ "KEY `stage_id` (`stage_id`,`user_id`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin";

		String stageConstraintsQuery = "ALTER TABLE `"
				+ stage_table
				+ "` ADD CONSTRAINT `"
				+ stage_table
				+ "_ibfk_1` FOREIGN KEY (`stage_id`) REFERENCES "
				+ workflow_table
				+ " (`stage_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "ADD CONSTRAINT `"
				+ stage_table
				+ "_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `login_credentials` (`user_id`) "
				+ "ON DELETE CASCADE ON UPDATE CASCADE";

		String itemCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ item_table
				+ "` ( `item_id` int(5) NOT NULL AUTO_INCREMENT,"
				+ "`item_name` varchar(30) COLLATE utf8_bin NOT NULL,"
				+ " `item_description` varchar(100) COLLATE utf8_bin NOT NULL,"
				+ " `current_stage_id` int(5) NOT NULL,"
				+ " `remarks` longtext COLLATE utf8_bin NOT NULL,"
				+ " `file_path` varchar(500) COLLATE utf8_bin NOT NULL, "
				+ "PRIMARY KEY (`item_id`), KEY `current_stage_id` (`current_stage_id`))"
				+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ";

		String itemConstraintsQuery = "ALTER TABLE `" + item_table
				+ "` ADD CONSTRAINT `" + item_table
				+ "_ibfk_1` FOREIGN KEY (`current_stage_id`) REFERENCES `"
				+ workflow_table
				+ "` (`stage_id`) ON DELETE CASCADE ON UPDATE CASCADE";

		String leaderCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ lead_bucket
				+ "` (  `sno` int(5) NOT NULL AUTO_INCREMENT," +
				"  `user_id` int(5) NOT NULL, "
				+ " `item_id` int(5) NOT NULL,  "
				+ "`stage_id` int(5) NOT NULL, "
				+ " `assigned_on` date NOT NULL,  "
				+ "`delivery_date` date NOT NULL, "
				+ " `status` enum('I','C','P','A','F','B') "
				+ "COLLATE utf8_bin NOT NULL COMMENT 'Incomplete,Complete,Partial,Assigned,Forward,Backward', `last_updated` date NOT NULL, "
				+ "PRIMARY KEY (`sno`,`user_id`,`item_id`,`stage_id`),  KEY `stage_id` (`stage_id`),  "
				+ "KEY `item_id` (`item_id`),KEY `user_id` (`user_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin";

		String leaderConstraintsQuery = "ALTER TABLE `"
				+ lead_bucket
				+ "`  ADD CONSTRAINT `"
				+ lead_bucket
				+ "_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES "
				+ "`login_credentials` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,  "
				+ "ADD CONSTRAINT `" + lead_bucket
				+ "_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES " + "`"
				+ item_table
				+ "` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ " ADD CONSTRAINT `" + lead_bucket
				+ "_ibfk_3` FOREIGN KEY (`stage_id`) REFERENCES " + "`"
				+ workflow_table
				+ "` (`stage_id`) ON DELETE CASCADE ON UPDATE CASCADE";

		String generalCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ general_bucket
				+ "` ( `sno` int(5) NOT NULL AUTO_INCREMENT," +
				" `user_id` int(5) NOT NULL, "
				+ " `item_id` int(5) NOT NULL,  "
				+ "`stage_id` int(5) NOT NULL, "
				+ " `assigned_on` date NOT NULL,  "
				+ "`delivery_date` date NOT NULL, "
				+ " `status` enum('I','C','P','A','F','B') "
				+ "COLLATE utf8_bin NOT NULL COMMENT 'Incomplete,Complete,Partial,Assigned,Forward,Backward', `last_updated` date NOT NULL, "
				+"`stage_lead_id` int(5) NOT NULL, "
				+ "PRIMARY KEY (`sno`,`user_id`,`item_id`,`stage_id`),  KEY `stage_id` (`stage_id`),  KEY `stage_lead_id` (`stage_lead_id`), "
				+ "KEY `item_id` (`item_id`),KEY `user_id` (`user_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin";

		String generalConstraintsQuery = "ALTER TABLE `"
				+ general_bucket
				+ "`  ADD CONSTRAINT `"
				+ general_bucket
				+ "_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES "
				+ "`login_credentials` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,  "
				+ "ADD CONSTRAINT `" + general_bucket
				+ "_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `"
				+ item_table
				+ "` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ " ADD CONSTRAINT `" + general_bucket
				+ "_ibfk_3` FOREIGN KEY (`stage_id`) REFERENCES `"
				+ workflow_table
				+ "` (`stage_id`) ON DELETE CASCADE ON UPDATE CASCADE," +
				" ADD CONSTRAINT `" +
				general_bucket +
				"_ibfk_4` FOREIGN KEY (`stage_lead_id`) REFERENCES `" +
				workflow_table +
				"` (`stage_lead_id`) ON DELETE CASCADE ON UPDATE CASCADE";

		try {
			if (DDLQueryInDB(workflowCreateTableQuery) == 1
					&& DDLQueryInDB(workflowConstraintsQuery) == 1) {
				System.out.println("workflow created");
				if (DDLQueryInDB(stageCreateTableQuery) == 1
						&& DDLQueryInDB(stageConstraintsQuery) == 1) {
					System.out.println("Stage created");
					if (DDLQueryInDB(itemCreateTableQuery) == 1
							&& DDLQueryInDB(itemConstraintsQuery) == 1) {
						System.out.println("item created");
						if (DDLQueryInDB(leaderCreateTableQuery) == 1
								&& DDLQueryInDB(leaderConstraintsQuery) == 1) {
							System.out.println("leader bucket created");
							if (DDLQueryInDB(generalCreateTableQuery) == 1
									&& DDLQueryInDB(generalConstraintsQuery) == 1) {
								System.out.println("general bucket created");
								return 1;
							}
						}
					}
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/* return 1 for success and 0 for failure */
	public static int DDLQueryInDB(String sqlQuery) {
		int result;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = new MySqlConnection().getConnection();
			pst = conn.prepareStatement(sqlQuery);
			result = pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return 1;
	}

}
