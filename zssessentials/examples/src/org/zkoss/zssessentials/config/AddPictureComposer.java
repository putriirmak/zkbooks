/* AddChartComposer.java

	Purpose:
		
	Description:
		
	History:
		Oct 25, 2011 9:23:21 AM, Created by henri

Copyright (C) 2011 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zssessentials.config;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.poi.ss.usermodel.ClientAnchor;
import org.zkoss.poi.ss.usermodel.Workbook;
import org.zkoss.poi.ss.usermodel.charts.ChartDataSource;
import org.zkoss.poi.ss.usermodel.charts.ChartGrouping;
import org.zkoss.poi.ss.usermodel.charts.ChartTextSource;
import org.zkoss.poi.ss.usermodel.charts.ChartType;
import org.zkoss.poi.ss.usermodel.charts.DataSources;
import org.zkoss.poi.ss.usermodel.charts.LegendPosition;
import org.zkoss.poi.ss.util.CellRangeAddress;
import org.zkoss.poi.xssf.usermodel.XSSFClientAnchor;
import org.zkoss.poi.xssf.usermodel.charts.XSSFPieChartData;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zss.model.Range;
import org.zkoss.zss.model.Ranges;
import org.zkoss.zss.model.Worksheet;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zssex.license.LicenseContent;
import org.zkoss.zssex.rt.RuntimeLicenseManager;
import org.zkoss.zssex.util.PictureHelper;

/**
 * @author henri
 *
 */
public class AddPictureComposer extends GenericForwardComposer {
	private Spreadsheet myss;
	
	public void onUpload$add(UploadEvent evt) throws Exception {
		final Media media = evt.getMedia();
		byte[] image = media.getByteData();
		
		//add a picture
		Worksheet sheet = myss.getSelectedSheet();
		Range rng = Ranges.range(sheet);
		ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, 2, 1, 7, 11); //C2:H12
		String fmt = media.getFormat();
		rng.addPicture(anchor, image, PictureHelper.getPictureFormat(fmt));
	}
	
}
