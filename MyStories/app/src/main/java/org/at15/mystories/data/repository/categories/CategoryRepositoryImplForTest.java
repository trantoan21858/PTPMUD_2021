package org.at15.mystories.data.repository.categories;

import org.at15.mystories.data.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImplForTest implements CategoryRepository {

    private static CategoryRepositoryImplForTest sSingleton;

    public static CategoryRepository getInstane() {
        if(sSingleton == null)
            sSingleton = new CategoryRepositoryImplForTest();
        return sSingleton;
    }

    private CategoryRepositoryImplForTest() {

    }
    @Override
    public void getCategories(LoadCategoryCallback callback) {
        List<CategoryModel> list = new ArrayList<CategoryModel>();

        list.add(new CategoryModel(
                "Tiên hiệp",
                "Truyện tiên hiệp thường kể về quá trình tu luyện và khám phá thế giới tu sĩ thần tiên đầy bí ẩn của nhân vật chính.",
                "https://image.lag.vn/upload/news/17/10/26/pham_nhan_tru_tien_vng_open_beta_4_INZM.jpg"
        ));

        list.add(new CategoryModel(
                "Kiếm hiệp",
                "Truyện thường xoay quanh cuộc đời của nhân vật chính, quá trình rèn luyện, trưởng thành, tìm kiếm, học tập các bí kíp võ công, cùng những cuộc phiêu lưu, truy đuổi, chém giết... đầy nguy hiểm và cơ hội trong giới võ lâm giang hồ.",
                "https://i.pinimg.com/originals/ac/1f/34/ac1f34134603e4a4bd1a90ad20f9a13d.jpg"
        ));

        list.add(new CategoryModel(
                "Ngôn tình",
                "Truyện thuộc kiểu lãng mạn, kể về những sự kiện vui buồn trong tình yêu của nhân vật chính.",
                "https://thuthuatnhanh.com/wp-content/uploads/2021/07/hinh-anh-ngon-tinh-800x566.jpg"
        ));

        callback.onLoadSucces(list);
    }
}
