package de.setsoftware.reviewtool.model.api;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Interface for the results from getting the relevant changes for a ticket from the ticket system.
 */
public interface IChangeData {

    /**
     * Returns the {@link IChangeSource} that created this object.
     */
    public abstract IChangeSource getSource();

    /**
     * Returns all {@link ICommit}s matching the given ticket, sorted by commit date from oldest to newest.
     */
    public abstract List<? extends ICommit> getMatchedCommits();

    /**
     * Returns the paths for all locally modified files together with their repository path.
     */
    public abstract Map<File, IRevisionedFile> getLocalPathMap();

    /**
     * Returns all {@link IRepository}s that contain commits matching the given ticket.
     */
    public abstract Set<? extends IRepository> getRepositories();

}
