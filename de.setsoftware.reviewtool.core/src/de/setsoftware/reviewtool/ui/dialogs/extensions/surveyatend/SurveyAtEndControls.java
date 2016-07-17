package de.setsoftware.reviewtool.ui.dialogs.extensions.surveyatend;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.setsoftware.reviewtool.base.Pair;
import de.setsoftware.reviewtool.model.EndTransition;
import de.setsoftware.reviewtool.model.EndTransition.Type;
import de.setsoftware.reviewtool.telemetry.Telemetry;
import de.setsoftware.reviewtool.ui.dialogs.EndReviewExtensionData;

/**
 * The combo boxes for the survey in the end review dialog.
 */
public class SurveyAtEndControls implements EndReviewExtensionData {

    private final List<Pair<Question, Combo>> combos = new ArrayList<>();

    public SurveyAtEndControls(Composite comp, List<Question> questions) {
        for (final Question q : questions) {
            final Label label = new Label(comp, 0);
            label.setText(q.getText());
            final Combo combo = new Combo(comp, SWT.READ_ONLY);
            for (final Answer a : q.getChoices()) {
                combo.add(a.getText());
            }
            this.combos.add(Pair.create(q, combo));
        }
    }

    @Override
    public boolean okPressed(EndTransition typeOfEnd) {
        if (typeOfEnd.getType() == Type.PAUSE) {
            return false;
        }

        final List<Pair<String, String>> answers = new ArrayList<>();
        for (final Pair<Question, Combo> combo : this.combos) {
            final String answerId = combo.getFirst().getIdForChoiceText(combo.getSecond().getText());
            if (answerId == null) {
                MessageDialog.openError(null, "Bitte Umfrage ausfüllen",
                        "Bitte beantworte die im Dialog angezeigten Fragen.");
                return true;
            }
            answers.add(Pair.create(combo.getFirst().getId(), answerId));
        }
        Telemetry.get().surveyResult(answers);
        return false;
    }

}
