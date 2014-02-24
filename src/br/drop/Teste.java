package br.drop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import javax.swing.JFileChooser;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;

public class Teste {

	public static void DropboxConexao() throws IOException, DbxException {

		// Get your app key and secret from the Dropbox developers website.
		final String APP_KEY = "ja88aa7updfevrs";
		final String APP_SECRET = "akrtcb8ropqftov";

		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

		DbxRequestConfig config = new DbxRequestConfig("CriarJsonEstoque",
				Locale.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

		// Have the user sign in and authorize your app.
		String code = "tLrkiHGS_jAAAAAAAAAAAerPoFgPiKk-_QxzFBp1Lwo";
		// This will fail if the user enters an invalid authorization code.
		DbxAuthFinish authFinish = webAuth.finish(code);
		// tLrkiHGS_jAAAAAAAAAAAerPoFgPiKk-_QxzFBp1Lwo
		DbxClient client = new DbxClient(config, authFinish.accessToken);

		System.out.println("Linked account: "
				+ client.getAccountInfo().displayName);
		System.out.println(client.getAccountInfo().referralLink);
		System.out.println(client.getAccountInfo().country);
		// String caminhoArquivo = "";
		// JFileChooser arquivo = new JFileChooser();
		// int retorno = arquivo.showOpenDialog(null);
		// if (retorno == JFileChooser.APPROVE_OPTION) {
		// caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
		// }
		// File inputFile = new File(caminhoArquivo);
		// FileInputStream inputStream = new FileInputStream(inputFile);
		// try {
		// DbxEntry.File uploadedFile = client.uploadFile(caminhoArquivo,
		// DbxWriteMode.add(), inputFile.length(), inputStream);
		// System.out.println("Uploaded: " + uploadedFile.toString());
		// } finally {
		// inputStream.close();
		// }
		//
		// DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
		// System.out.println("Files in the root path:");
		// for (DbxEntry child : listing.children) {
		// System.out.println("	" + child.name + ": " + child.toString());
		// }
		//
		// FileOutputStream outputStream = new FileOutputStream(caminhoArquivo);
		// try {
		// DbxEntry.File downloadedFile = client.getFile(caminhoArquivo, null,
		// outputStream);
		// System.out.println("Metadata: " + downloadedFile.toString());
		// } finally {
		// outputStream.close();
		// }
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws DbxException
	 */
	// tLrkiHGS_jAAAAAAAAAAAerPoFgPiKk-_QxzFBp1Lwo
	public static void main(String[] args) {
		try {
			DropboxConexao();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**



com.dropbox.core.DbxException$BadRequest: {"error_description": "code has expired (within the last hour)", "error": "invalid_grant"}
at com.dropbox.core.DbxRequestUtil.unexpectedStatus(DbxRequestUtil.java:202)
at com.dropbox.core.DbxWebAuthHelper$1.handle(DbxWebAuthHelper.java:46)
at com.dropbox.core.DbxWebAuthHelper$1.handle(DbxWebAuthHelper.java:42)
at com.dropbox.core.DbxRequestUtil.finishResponse(DbxRequestUtil.java:296)
at com.dropbox.core.DbxRequestUtil.doPostNoAuth(DbxRequestUtil.java:289)
at com.dropbox.core.DbxWebAuthHelper.finish(DbxWebAuthHelper.java:40)
at com.dropbox.core.DbxWebAuthNoRedirect.finish(DbxWebAuthNoRedirect.java:84)
at br.drop.Teste.DropboxConexao(Teste.java:41)
at br.drop.Teste.main(Teste.java:89)

*/