package org.at15.mystories.data.repository.novels;

import org.at15.mystories.data.model.NovelModel;

import java.util.ArrayList;
import java.util.List;

public class NovelsRepositoryImplForTest implements NovelsRepository {

    private static NovelsRepositoryImplForTest sSingleton;

    public static NovelsRepository getInstane() {
        if(sSingleton == null)
            sSingleton = new NovelsRepositoryImplForTest();
        return sSingleton;
    }

    private NovelsRepositoryImplForTest() {

    }

    @Override
    public void getNovels(NovelsRepository.LoadNovelsCallback callback, NovelFilter filter) {
        List<NovelModel> list = new ArrayList<NovelModel>();
        list.add(new NovelModel(
                "1",
                "Vợ Nhỏ Gả Thay Được Sủng Lên Mây",
                "https://sstruyen.com/assets/img/story//xvo_nho_ga_thay_duoc_sung_len_may.1633172549.jpg.pagespeed.ic.J_N6D6kelF.webp"
        ));

        list.add(new NovelModel(
                "2",
                "Vừa lúc gặp thời gian như thành",
                "https://sstruyen.com/assets/img/story//xvua_luc_gap_thoi_gian_nhu_thanh.1632051745.jpg.pagespeed.ic.-knFIMBOvZ.webp"
        ));

        list.add(new NovelModel(
                "3",
                "Hôn anh nói ngủ ngon",
                "https://sstruyen.com/assets/img/story//xhon_anh_noi_ngu_ngon.1631973245.jpg.pagespeed.ic.XUmGNUa6rF.webp"
        ));

        list.add(new NovelModel(
                "4",
                "Chỉ phu vi thê",
                "https://sstruyen.com/assets/img/story//xchi_phu_vi_the.1631973250.jpg.pagespeed.ic.QJMGjgHIM8.webp"
        ));

        list.add(new NovelModel(
                "5",
                "Nhục dục hắc ám",
                "https://sstruyen.com/assets/img/story//xnhuc_duc_hac_am.1631973254.jpg.pagespeed.ic.gF2t9OKF4p.webp"
        ));

        list.add(new NovelModel(
                "6",
                "Cuồng sủng",
                "https://sstruyen.com/assets/img/story//xcuong_sung.1631973257.jpg.pagespeed.ic.7RO0nNwrqW.webp"
        ));

        list.add(new NovelModel(
                "7",
                "Xin em đừng làm nũng",
                "https://sstruyen.com/assets/img/story//xxin_em_dung_lam_nung.1631945689.jpg.pagespeed.ic.npaaNDElhj.webp"
        ));

        list.add(new NovelModel(
                "8",
                "Vợ Nhỏ Gả Thay Được Sủng Lên Mây",
                ""
        ));

        list.add(new NovelModel(
                "9",
                "Tương tư thành bệnh",
                "https://sstruyen.com/assets/img/story//xtuong_tu_thanh_benh.1631690052.jpg.pagespeed.ic.vTg8vsQFhI.webp"
        ));

        list.add(new NovelModel(
                "10",
                "Ngôn Tình Yêu Đương Vụng Trộm",
                "https://sstruyen.com/assets/img/story//xngon_tinh_yeu_duong_vung_trom.1631414989.jpg.pagespeed.ic.27aR25q1Q_.webp"
        ));
        callback.onLoadSuccess(list);
    }
}
