package com.vlsm.controlles;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.vlsm.models.Host;

public class HostController {

	/**
	 * Prepare the values in the Host table
	 * 
	 * @param number
	 * @return
	 */
	public Vector<Object[]> prepareVlans(int number) {
		Vector<Object[]> vlans = new Vector<Object[]>();

		try {

			for (int i = 0; i < number; i++) {
				vlans.addElement(new Object[] { i, "Host " + i, "" });
			}

			return vlans;

		} catch (Exception er) {
			er.printStackTrace();
			return null;
		}

	}

	public List<Host> getHostsData(Vector<Vector> vector) {

		Vector<Host> data = new Vector<Host>();

		vector.stream().forEach(d -> {
			data.add(new Host(Integer.parseInt(String.valueOf(d.get(0))), String.valueOf(d.get(1)),
					Integer.parseInt(String.valueOf(d.get(2)))));
		});

		return data;

	}

}
