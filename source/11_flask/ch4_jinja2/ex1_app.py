# # # Jinja2 템플릿 문법 # # #
# 1. 변수 {{ var }} 또는 {{var : filter}}
    # 기본제공필터 : lower, upper, title(단어첫글자만 대문자), length, trim
    #      형변환 : {{number|int}}
# 2. 제어구조 {% .. %}
# 2-1 if : {% if 조건 %} A태그 {% elif 조건 %} B태그 {% else %} C태그 {% endif %}