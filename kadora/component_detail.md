# ボタンコンポーネント詳細設計書

## 1. 通常時のスタイル
| 項目 | 値 |
| --- | --- |
| 幅 | 160px |
| 高さ | 100px |
|  パディング| 24px |
| 背景 | #3b82f6 |

```css
.btn{
    width: 160px;
    height: 100px;
    padding: 24px;
    background-color: #3b82f6;
    color: #fff;
    border: none;
    border-radius: 10px;
    transition: background-color 200ms ease, transform 150ms ease;
    
}
```

## 2. インタラクション状態
### :hover
```css
.btn:hover{background-color: #2563eb;}
```
### :active（クリック時）
```css
.btn:active { transform: scale(0.96); }
```
### :focus（フォーカス時）
```css
.btn:focus { outline: 3px solid #93c5fd; outline-offset: 2px; }
```

## 3. アニメーション（transition）
| 対象 | プロパティ | 時間 | イージング |
|---|---|---|---|
| 背景色 | background-color | 200ms | ease |
| 拡大縮小 | transform | 150ms | ease |