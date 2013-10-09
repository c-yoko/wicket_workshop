/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.workshop01;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.UrlPathPageParametersEncoder;
import org.apache.wicket.resource.DynamicJQueryResourceReference;
import org.wicket_sapporo.workshop01.page.WS01IndexPage;
import org.wicket_sapporo.workshop01.page.CleanUrl.idReceiptPage;

/**
 * Wicketアプリケーションの全体の設定などを記述するクラス.
 *
 * @author Hiroto Yamakawa
 */
public class WS01Application extends WebApplication {

	@Override
	protected void init() {
		super.init();
		// サーバ・クライアント間のリクエスト・レスポンスの文字エンコード
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		// Wicketに取り込まれるHTMLファイルのエンコード
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		// IE6/7/8 は JQuery1, それ以外はJQuery2を利用
		getJavaScriptLibrarySettings().setJQueryReference(new DynamicJQueryResourceReference());

		mountInit();
	}

	private void mountInit() {
		// クラスへのアクセスをどのURLファイルパスにマッピングするか。第3引数は、パラメータの整形方法の設定.
		mount(new MountedMapper("/idReceipt", idReceiptPage.class, new UrlPathPageParametersEncoder()));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return WS01IndexPage.class;
	}

}
