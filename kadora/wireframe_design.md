# 【基本設計書】ユーザーマイページ

## 1.概要・案件定義
- **目的**：ユーザーが自身のステータスを確認・管理する画面。
- **対象URL**:`/profile`
- **アクセス制限**:ログイン済みユーザーのみ(未承認はリダイレクト)

## 2.ワイヤーフレーム

+------------------------------------------------------+
| Engineer Guild                    [Settings] [Logout]|  <- Header
+------------------------------------------------------+
|                                                      |
|  +----------+   +---------------------------------+  |
|  |          |   | Name: Aqs Starforge             |  |  
<- Profile Section
|  |  Avatar  |   | Rank: *** (Silver Guild Master) |  |     (Flexbox: row)
|  | 120x120  |   | Team: Frontend Guild            |  |
|  |          |   | Bio: Aiming to be full-stack    |  |
|  +----------+   +---------------------------------+  |
|                                                      |
|  === Achievements ===                                |
|  +-------------+  +-------------+  +-------------+   |
|  | Sword Master|  | Magic Basic |  | Explorer    |   |  
<- Achievements
|  | Level: MAX  |  | Level: Lv.2 |  | Level: Lv.5 |   |     (CSS Grid: 3 cols)
|  +-------------+  +-------------+  +-------------+   |
|                                                      |
+------------------------------------------------------+
| (c) 2026 Engineer Guild. All rights reserved.        |  
<- Footer
+------------------------------------------------------+

## 3.コンポーネント一覧
|コンポーネント名|責務|再利用可否|
|Header|サイト名ログアウトを表示|可|
|Avatar|ユーザーのアバター画像を表示|可|
|ProfileInfo|名前ランク所属を表示|不可|
|Achievements|BadgeCardを3列で並べる|不可|
|Footer|コピーライトを表示|可|

## 4.レイアウト設計表
|エリア名|レイアウト手法|
|Header|Flexbox|
|ProfileSection|Flexbox|
|Achievements|Grid|
|Footer|flexbox|