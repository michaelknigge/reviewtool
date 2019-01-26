package de.setsoftware.reviewtool.changesources.git;

///**
// * Encapsulates the "revision" (commit) of a Git working copy.
// */
//final class GitWorkingCopyRevision extends AbstractGitRevision {
//
//    private final GitWorkingCopy wc;
//    private final SortedMap<String, CachedLogEntryPath> paths;
//
//    /**
//     * Constructor.
//     *
//     * @param repository The associated repository.
//     * @param paths The paths changed in the working copy.
//     */
//    GitWorkingCopyRevision(final GitWorkingCopy wc, final SortedMap<String, CachedLogEntryPath> paths) {
//        this.wc = wc;
//        this.paths = paths;
//    }
//
//    /**
//     * Returns the associated working copy.
//     */
//    GitWorkingCopy getWorkingCopy() {
//        return this.wc;
//    }
//
//    @Override
//    public GitRepository getRepository() {
//        return this.wc.getRepository();
//    }
//
//    @Override
//    public String getRevisionString() {
//        return "WORKING";
//    }
//
//    @Override
//    public ILocalRevision toRevision() {
//        return ChangestructureFactory.createLocalRevision(this.wc);
//    }
//
//    @Override
//    public Date getDate() {
//        return new Date(Long.MAX_VALUE);
//    }
//
//    @Override
//    public String getAuthor() {
//        return "";
//    }
//
//    @Override
//    public String getMessage() {
//        return "";
//    }
//
//    @Override
//    public Map<String, CachedLogEntryPath> getChangedPaths() {
//        return this.paths;
//    }
//
//    @Override
//    public String toPrettyString() {
//        return "(work in progress)";
//    }
//
//    @Override
//    public String toString() {
//        return this.getRepository() + "@WORKING";
//    }
//}
