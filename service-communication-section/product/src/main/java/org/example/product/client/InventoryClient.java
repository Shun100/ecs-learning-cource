package org.example.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * GETリクエスト送信
 * 
 * ## 実装クラスが必要？
 * 通常のJavaのinterfaceであれば実装クラスが必要だが、@FeignClientを付与しているためSpring Cloud
 * OpenFeignが自動的に実装を自動生成する。つまり、自分で実装クラスを書く必要は無い。
 * 
 * ## アノテーションの説明
 * - @FeignClient: HTTP通信を行うクライアントを定義する。
 * - @GetMapping: HTTPのGETリクエストを送信する。
 * - @PathVariable: クエリパラメータを埋め込む。
 */
@FeignClient(name = "inventory-client", url = "${inventory.client.url}")
public interface InventoryClient {
    @GetMapping("/{productId}")
    GetInventoryDecreaseResponse get(@PathVariable Long productId);
}
