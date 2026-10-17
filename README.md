# README

## タスク定義について

こんかいのデプロイでは2つのタスク定義を使用している。

- タスク定義1: `cicd-section/.aws/task-def-api.json`
- タスク定義2: AWS Condole > IAM > UpdateECSTask

それぞれの違いをまとめる。

- タスク定義1
  - **ECSでコンテナをどのように実行するかを定義する設定**
  - JSONの主なキー: `taskDefinitionArn`, `containerDefinitions`, `family`
  - コンテナイメージのURI
  - コンテナポート (8080)
  - CPU・メモリなどの実行リソース
  - CloudWatch Logsの出力先
  - Fargateの実行方式
  - タスク実行ロール

- タスク定義2
  - **GitHub Actionsなどの処理に、どのAWS操作を許可するかを定義するIAMポリシー**
  - JSONの主なキー: `Version`, `Statement`, `Action`, `Resource`
  - ECSサービスの更新
  - 新しいECSタスク定義の取得
  - ECRへのイメージのプッシュ・取得
  - ECSサービスの情報取得
  - IAMロールをECSに渡す権限
