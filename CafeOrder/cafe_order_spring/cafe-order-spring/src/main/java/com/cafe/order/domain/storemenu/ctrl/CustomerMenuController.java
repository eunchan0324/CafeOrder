package com.cafe.order.domain.storemenu.ctrl;

import com.cafe.order.domain.favorite.service.FavoriteMenuService;
import com.cafe.order.domain.menu.dto.Category;
import com.cafe.order.domain.store.entity.Store;
import com.cafe.order.domain.store.service.StoreService;
import com.cafe.order.domain.storemenu.dto.CustomerMenuDetailResponse;
import com.cafe.order.domain.storemenu.dto.CustomerMenuResponse;
import com.cafe.order.domain.storemenu.service.StoreMenuService;
import com.cafe.order.global.security.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/customer/menus")
@Controller
@RequiredArgsConstructor
public class CustomerMenuController {

    private final StoreMenuService storeMenuService;
    private final StoreService storeService;
    private final FavoriteMenuService favoriteMenuService;

    /**
     * READ : 지점의 전체 메뉴 + 판매 가능 여부(재고 상태) 조회
     */
    @GetMapping
    public String storeMenuList(Model model) {
        // TODO : 로그인 기능 이후 수정
        Integer storeId = 1; // 임시 강남점
        Store store = storeService.findById(storeId);

        if (store == null) {
            throw new IllegalArgumentException("존재하지 않는 지점입니다: " + storeId);
        }

        List<CustomerMenuResponse> rawMenus = storeMenuService.findAllMenusWithAvailability(storeId);

        // 카테고리 별 그룹핑
        Map<Category, List<CustomerMenuResponse>> groupedMenus = rawMenus.stream()
                .collect(Collectors.groupingBy(CustomerMenuResponse::getCategory));

        model.addAttribute("store", store);
        model.addAttribute("groupedMenus", groupedMenus);
        model.addAttribute("allCategories", Category.values());

        return "customer/menus/list";
    }

    /**
     * READ : 메뉴 상세보기
     */
    @GetMapping("/{menuId}")
    public String detail(@AuthenticationPrincipal CustomUserDetails userDetails,
                         @PathVariable UUID menuId,
                         Model model) {

        // 비로그인 방어 로직
        if (userDetails == null) {
            return "redirect:/login";
        }

        // todo : 지점 선택 기능 후, storeId 리팩토링
        Integer storeId = 1;

        Integer userId = userDetails.getId();

        CustomerMenuDetailResponse menuDetail = storeMenuService.findMenuDetail(storeId, menuId, userId);

        model.addAttribute("menu", menuDetail);

        return "customer/menus/detail";
    }

    /**
     * COMMAND: 찜 상태를 토글
     */
    @PostMapping("/{menuId}/toggle-favorite")
    public String toggleFavorite(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable UUID menuId) {
        // 비로그인 방어 로직
        if (userDetails == null) {
            return "redirect:/login";
        }

        Integer userId = userDetails.getId();

        favoriteMenuService.toggleFavorite(userId, menuId);

        return "redirect:/customer/menus/" + menuId;
    }
}
