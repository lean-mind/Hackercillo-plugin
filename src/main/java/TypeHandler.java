package main.java;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

class HackerTypeHandler extends TypedHandlerDelegate {

    private int count = 0;
    private final String text = "" +
            "line 1 asdfasdf \n line asdfasdf  2 \n line 3 asdfasdf \n line 4 asdfasdfasdf \n line 5"+
            "line 1 asdfasdf \n line asdfasdf  2 \n line 3 asdfasdf \n line 4 asdfasdfasdf \n line 5"+
            "line 1 asdfasdf \n line asdfasdf  2 \n line 3 asdfasdf \n line 4 asdfasdfasdf \n line 5"+
            "line 1 asdfasdf \n line asdfasdf  2 \n line 3 asdfasdf \n line 4 asdfasdfasdf \n line 5"+
            "line 1 asdfasdf \n line asdfasdf  2 \n line 3 asdfasdf \n line 4 asdfasdfasdf \n line 5";

    @NotNull
    @Override
    public Result charTyped(char c, @NotNull Project project, @NotNull Editor editor,
                            @NotNull PsiFile file) {
        final Document document = editor.getDocument();
        Runnable runnable = () -> {
            count = (count + 5) % text.length();
            document.setText(text.substring(0, count) + "\n");
        };
        WriteCommandAction.runWriteCommandAction(project, runnable);
        return Result.STOP;
    }

}
