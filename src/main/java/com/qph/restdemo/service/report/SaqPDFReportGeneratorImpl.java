package com.qph.restdemo.service.report;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Objects;

@Component
public class SaqPDFReportGeneratorImpl implements SaqReportGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(SaqPDFReportGeneratorImpl.class);

    private static final String FOP_RESOURCES_PATH = "classpath:/report/";
    private static final String SUPPORTED_FORMAT = "pdf";
    private final String XSTL_REPORT = FOP_RESOURCES_PATH + "test_saq_report.xslt";

    private final FopFactory fopFactory;
    private final TransformerFactory transformerFactory;
    private final ResourceLoader resourceLoader;
    private final URIResolver uriResolver;

    @Autowired
    public SaqPDFReportGeneratorImpl(final FopFactory fopFactory,
                                     final TransformerFactory transformerFactory,
                                     final ResourceLoader resourceLoader, URIResolver uriResolver) {

        this.fopFactory = fopFactory;
        this.transformerFactory = transformerFactory;
        this.resourceLoader = resourceLoader;
        this.uriResolver = uriResolver;
    }

    @Override
    public byte[] generateReport(String language) {
        try {
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Report><contentFont>SimSun</contentFont><by>ronald@sedexglobal.com</by><exportedDate>18/10/2016 04:10</exportedDate><siteDetails><company><name>_Sedex*Test_AB</name><code>ZC1027089</code></company><site><name>abc test</name><code>ZS15809497</code></site><address><addressLine1>abc</addressLine1><city>London</city><postCode>se1 se1</postCode><countryCode>GB</countryCode><countryName>United Kingdom</countryName></address><lastUpdated>01/10/2016 08:07</lastUpdated><sectorProfiles>SERVPROV</sectorProfiles><sectorProfiles>INTERMEDI</sectorProfiles><completion>0.0</completion></siteDetails></Report>";
            if(Objects.equals(language, "ja")) {
                xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Report><contentFont>Sazanami Mincho</contentFont><by>ronald@sedexglobal.com</by><exportedDate>20/10/2016 01:40</exportedDate><siteDetails><company><name>_Sedex*Test_Chinese company for sunny</name><code>ZC1071772</code></company><site><name>Heavy Engineering</name><code>ZS5021765</code></site><address><addressLine1>adfg</addressLine1><city>adfg</city><postCode>adfg</postCode><countryCode>AL</countryCode></address><lastUpdated>11/09/2016 07:59</lastUpdated><sectorProfiles>HEAVMANU</sectorProfiles><completion>0.0</completion></siteDetails><workerNumbers><workderType>Travailleurs permanents</workderType><women>0</women><men>3</men><total>3</total></workerNumbers><saqResultsList><headers>プロフィール</headers><headers>Question</headers><headers>Answer</headers><headers>Global?</headers><saqResults><saqQuestionCode>ZQQ20050021</saqQuestionCode><question>次にあげる基準に基づいて、この工場/施設は保証又は監視されていますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050026</saqQuestionCode><question>どのように現地法規制の最新情報や変更点について把握し、自社の工場/施設の順守を確かなものとしていますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050030</saqQuestionCode><question>この工場/施設では、法規制、承諾、許認可における違反から、公的な通達を受けたり、訴追されたことはありますか。（3年以内に）</question><answer>、訴追されたことはありますか。（3年以内に）</answer></saqResults><saqResults><saqQuestionCode>ZQQ20050034</saqQuestionCode><question>この工場/施設では、法律で規定された、関連があり適切な許可を全て取得していますか。例：操業許可、廃棄物処理　等</question><answer></answer></saqResults></saqResultsList><saqResultsList><headers>労働</headers><headers>Question</headers><headers>Answer</headers><headers>Global?</headers><saqResults><saqQuestionCode>ZQQ20050048</saqQuestionCode><question>労働課題や人材マネジメント方法に関する自社の方針を明確に示した文書はありますか。該当するものを全て選択してください。</question><answer>た文書はありますか。該当するものを全て選択してください。</answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050050</saqQuestionCode><question>自社の基準への適合能力に基づいて、サプライヤーを評価し、選択するための手順書がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050055</saqQuestionCode><question>従業員/労働者および/またはサプライヤーが、内密な懸念事項について助言を受けたり、報告したりするための正式なプロセス（例：ヘルプライン、内部通報制度）はありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050056</saqQuestionCode><question>倫理的な取引に関する方針と労働基準の要件が満たしているかに責任をもつ上級管理職はいますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050062</saqQuestionCode><question>全従業員/労働者が、労働時間外、または交代勤務時間後に、自由に工場/施設を離れることができますか（工場内に居住する労働者も含む）。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050063</saqQuestionCode><question>しかるべき通知をすれば、全従業員/労働者は自由に退職することができますか。</question><answer>た文書はありますか。該当するものを全て選択してください。</answer></saqResults><saqResults><saqQuestionCode>ZQQ20050072</saqQuestionCode><question>囚人を従業員/労働者として使っていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050147</saqQuestionCode><question>全ての労働時間および残業が法律に則って行われていることを確かめる手続きがありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050148</saqQuestionCode><question>この地域における週当たりの法定最大労働時間数（残業も含む）は何時間ですか、</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050149</saqQuestionCode><question>通常の週当たりの労働時間は何時間ですか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050151</saqQuestionCode><question>最大労働時間数（残業も含む）を超えた従業員/労働者はいますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050155</saqQuestionCode><question>この工場/施設の全ての直接雇用の従業員/労働者が、法に則った休憩時間を得ていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050156</saqQuestionCode><question>残業は任意ですか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050354</saqQuestionCode><question>#N/A</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050160</saqQuestionCode><question>機会の平等に関する明文化された方針はありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050161</saqQuestionCode><question>雇用および昇進における機会の平等を保証し、差別を防止するための明文化された手続きはありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050189</saqQuestionCode><question>明文化された懲戒手続きがありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050190</saqQuestionCode><question>明文化された苦情処理手続きがありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050193</saqQuestionCode><question>ハラスメントやいじめを防止するための明文化された手続きがありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050195</saqQuestionCode><question>ヘルプラインや内部告発制度等、従業員/労働者が差別やハラスメントを匿名で告発するための手段がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050074</saqQuestionCode><question>全従業員/労働者に結社の自由と団体交渉権を認める明文化された方針はありますか。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050084</saqQuestionCode><question>団体交渉に関する協定がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050208</saqQuestionCode><question>自社が人権を尊重することを確約している方針はありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050209</saqQuestionCode><question>人権への自社の影響を特定、評価し、（適切に）是正する手続きはありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050087</saqQuestionCode><question>従業員/労働者に居住施設を提供していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050103</saqQuestionCode><question>児童労働の防止、廃絶についての明文化された方針がありますか。該当するものを全て選択してください。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050104</saqQuestionCode><question>あなたの国の労働にあたっての最低年齢はいくつですか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050105</saqQuestionCode><question>この工場/施設の全従業員/労働者について、出生日証明の写しを含む個人記録を保有していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050108</saqQuestionCode><question>職場において、法定の最低年齢に満たない従業員/労働者が発見されたことはありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050110</saqQuestionCode><question>法定の最低年齢以上だが１８歳以下の従業員/労働者はいますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050116</saqQuestionCode><question>直接・間接雇用の全従業員/労働者に準拠法に則った給与が支給されることをどのように確認していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050119</saqQuestionCode><question>御社の工場/施設に適用される、法または労働協約によって定められた、法定最低賃金はありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050141</saqQuestionCode><question>全従業員/労働者に、通常の時間給よりも多い残業代が支給されていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050143</saqQuestionCode><question>この工場/施設における給与体系はどのように設定されていますか。該当するものを全て選択してください。</question><answer>た文書はありますか。該当するものを全て選択してください。</answer></saqResults><saqResults><saqQuestionCode>ZQQ20050204</saqQuestionCode><question>自社が生産している、あるいは調達している製品にこれらの鉱物が含まれますか。該当するものを全て選択してください。</question><answer></answer></saqResults></saqResultsList><saqResultsList><headers>安全衛生</headers><headers>Question</headers><headers>Answer</headers><headers>Global?</headers><saqResults><saqQuestionCode>ZQQ20050255</saqQuestionCode><question>日常業務の中で、機械装置および/または車両を使用していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050261</saqQuestionCode><question>施設で使用されている全化学物質の完全一覧表はありますか（農薬、肥料、ドライクリーニング溶液を含む）。次の中から選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050262</saqQuestionCode><question>それぞの化学物質の製品安全データシート（MSDS）は容易に入手可能ですか？該当する回答を選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050270</saqQuestionCode><question>安全衛生リスクアセスメントの一環として、空気の品質（溶解および粉塵レベル）についてモニタリングを行っていますか</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050273</saqQuestionCode><question>労働者の健康および健康で安心した生活（well being）への、事業に関連した潜在的なリスクを特定したことはありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050274</saqQuestionCode><question>労働者の健康へのリスクを防止し、低減するためのプログラムがありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050211</saqQuestionCode><question>明文化された安全衛生に関する方針はありますか。該当するものを全て選択してください。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050213</saqQuestionCode><question>安全衛生リスクを特定し、評価するための明文化された方針がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050214</saqQuestionCode><question>従業員/労働者にどのように安全衛生に関する要求事項をを伝え、その理解を確かめていますか。該当するもの全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050223</saqQuestionCode><question>安全衛生について責任を持つ専属のシニアマネージャーか有資格安全管理者のどちらかまたは両方がいますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050226</saqQuestionCode><question>安全衛生リスクアセスメントを実施していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050231</saqQuestionCode><question>担当業務において必要な場合は、全従業員/労働者に対し防護装備(例：防護服、靴、手袋、耳や目の保護装備、防塵マスク）を支給していますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050232</saqQuestionCode><question>事故やけがは全て記録していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050237</saqQuestionCode><question>救急の場合は、全ての従業員/労働者が医療機関（工場/施設内または施設外）を受診することができますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050240</saqQuestionCode><question>すべての従業員/労働者は業務に関連した安全衛生に関する研修を受けていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050242</saqQuestionCode><question>この工場/施設での緊急避難について明文化されたものはありますか（例：火災、作業域への煙の流入等）</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050243</saqQuestionCode><question>避難訓練はどのくらいの頻度で行っていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050247</saqQuestionCode><question>この工場/施設内のどこにいても聞こえる緊急警報装置がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050249</saqQuestionCode><question>緊急時に全ての労働者が建物から迅速且つ安全に避難できるように適切に設計され、整備され、示された非常口はありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050250</saqQuestionCode><question>非常口は常に施錠されておらず、封鎖されていない状態になっていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050251</saqQuestionCode><question>少なくとも法で定められた、あるいは推奨される数の消火器、ホース、防火用毛布を所持しており、それらの使い方を明確に示してある使用書はありますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050252</saqQuestionCode><question>製造および保管域における喫煙は禁止されていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050253</saqQuestionCode><question>現地の消防署から発行された有効な消防検査証がありますか。</question><answer></answer></saqResults></saqResultsList><saqResultsList><headers>ビジネス倫理</headers><headers>Question</headers><headers>Answer</headers><headers>Global?</headers><saqResults><saqQuestionCode>ZQQ20050297</saqQuestionCode><question>賄賂、汚職、不正行為を禁止する明文化された方針がありますか。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050300</saqQuestionCode><question>賄賂や汚職にどのように対処すべきかについて、従業員/労働者に対し適切な研修を行っていますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050285</saqQuestionCode><question>明文化されたビジネス倫理方針、又はビジネスインテグリティ方針がありますか。該当するものを全て選択してください。</question><answer></answer><global>X</global></saqResults></saqResultsList><saqResultsList><headers>環境</headers><headers>Question</headers><headers>Answer</headers><headers>Global?</headers><saqResults><saqQuestionCode>ZQQ20050347</saqQuestionCode><question>顧客に供給している製品の重要な環境影響について測定していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050301</saqQuestionCode><question>環境に関する全ての現地法および規制を遵守していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050302</saqQuestionCode><question>環境マネジメントに関する明文化された方針がありますか。該当するものを全て選択してください。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050304</saqQuestionCode><question>現場の活動、製品、およびサービスの環境側面についてどのように特定し、評価するかについて明文化された手続きはありますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050305</saqQuestionCode><question>自社のビジネス活動が及ぼす重大な環境への影響について特定し、評価したことはありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050307</saqQuestionCode><question>現場の活動、製品、およびサービスが及ぼす環境への影響について削減する目標がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050308</saqQuestionCode><question>環境マネジメントに責任をもつ上級管理職はいますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050327</saqQuestionCode><question>大気への排出について削減目標を設定していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050328</saqQuestionCode><question>エネルギー使用削減の目標がありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050309</saqQuestionCode><question>廃棄物管理に関する明文化された方針がありますか。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050310</saqQuestionCode><question>廃棄物の保管、排出、処分に関して明文化された方針はありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050313</saqQuestionCode><question>あなたの工場/施設の廃棄物コンテナは良好な状態であり、集荷された廃棄物に適したものですか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050314</saqQuestionCode><question>あなたの工場/施設から排出される廃棄物の削減に関し目標を設定していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050315</saqQuestionCode><question>原材料の調達にあたって、環境およびサステナビリティに関する基準を考慮していますか。該当するものをすべて選んでください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050317</saqQuestionCode><question>水の管理に関し明文化された方針はありますか。</question><answer></answer><global>X</global></saqResults><saqResults><saqQuestionCode>ZQQ20050318</saqQuestionCode><question>水使用量の削減および再利用に関し目標を設定していますか。該当するものを全て選択してください。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050321</saqQuestionCode><question>水質への影響や排水の影響について積極的に管理していますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050322</saqQuestionCode><question>汚染事故を管理する手続きがありますか。</question><answer></answer></saqResults><saqResults><saqQuestionCode>ZQQ20050323</saqQuestionCode><question>事業プロセスの大気、水質、資源、土壌の潜在的汚染リスクについて特定し、評価したことはありますか。</question><answer></answer></saqResults></saqResultsList></Report>";
            }
            LOG.debug("Start transforming  data to pdf: {}", xml);
            final ByteArrayOutputStream pdfWriter = new ByteArrayOutputStream();
            final Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fopFactory.newFOUserAgent(), pdfWriter);
            final Transformer transformer = transformerFactory.newTransformer(new StreamSource(resourceLoader.getResource(XSTL_REPORT).getInputStream()));
            transformer.setURIResolver(uriResolver);
            SAXResult result = new SAXResult(fop.getDefaultHandler());
            transformer.transform(new StreamSource(new StringReader(xml)), result);
            LOG.debug("Stop transforming data {}", pdfWriter.toString());
            return pdfWriter.toByteArray();
        } catch (Exception e) {
            LOG.error("Error while generating pdf from XSL-FO", e);
            throw new RuntimeException("Could not generate pdf from XSL-FO");
        }
    }

    @Override
    public boolean formatSupported(String formatType) {
        return SUPPORTED_FORMAT.equalsIgnoreCase(formatType);
    }
}