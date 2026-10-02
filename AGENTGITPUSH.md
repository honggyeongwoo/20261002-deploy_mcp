# GitHub 저장소 생성 및 Push 절차

현재 프로젝트에서 GitHub 저장소를 만들거나 기존 저장소에 변경사항을 push할 때 사용한다.

## 진행 순서

1. `gh auth status`로 GitHub 로그인을 확인한다.
2. `git status --short --branch`와 `git remote -v`로 현재 저장소, 변경사항, 원격을 확인한다.
3. 원격 저장소가 없으면 새 저장소 이름과 공개 여부를 사용자에게 확인한 뒤 생성한다. 기존 저장소가 있으면 현재 원격을 유지한다.
4. 변경된 파일을 확인하고 `git add -A`로 현재 저장소의 변경사항을 스테이징한다. 커밋 전에 `git diff --cached --stat` 및 `git status --short`로 대상 파일을 점검한다.
5. 변경 내용을 요약하는 짧고 구체적인 커밋 메시지로 커밋한다.
6. `main` 브랜치에 push하고 `git status --short --branch`로 원격 추적 및 작업 트리를 확인한다.

## 명령 예시

```bash
gh auth status
git status --short --branch
git remote -v
git add -A
git diff --cached --stat
git commit -m "docs: summarize the change"
git push origin main
git status --short --branch
```

새 원격이 필요한 경우에만 저장소 이름을 확인한 후 다음 명령을 사용한다.

```bash
gh repo create <repository-name> --public --source=. --remote=origin --push
```

기존 프로젝트나 부모 폴더의 변경사항을 포함하지 않도록 저장소 루트를 확인한다. 토큰, 비밀번호, 개인 키 등 비밀정보가 스테이징되지 않았는지도 push 전에 확인한다.